package spark;
import com.alibaba.fastjson.JSONObject;
import org.apache.spark.sql.*;
import scala.Tuple2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ParquetReader {

    public static void main(String[] args) {


        SparkSession spark = SparkSession
                .builder()
                .appName("JavaWordCount")
                .getOrCreate();

        Dataset<Row> dSet = spark.read().parquet("E:\\Idea\\SparkTest\\src\\2015.parquet").orderBy("S_INFO_WINDCODE", "TRADE_DT");
        dSet.show(50);

        Encoder<StockRecord> StockRecordEncoder = Encoders.bean(StockRecord.class);

        dSet =  dSet.selectExpr("S_INFO_WINDCODE", "TRADE_DT", "S_DQ_CLOSE", "lag(S_DQ_CLOSE,1,S_DQ_CLOSE)" +
                " over(partition by S_INFO_WINDCODE order by TRADE_DT) as S_DQ_PRECLOSE");
        //dSet.show(500);

        Dataset<StockRecord>  test = dSet.selectExpr("S_INFO_WINDCODE", "TRADE_DT", "S_DQ_PRECLOSE", "S_DQ_CLOSE",
                                   "Round((S_DQ_CLOSE -  S_DQ_PRECLOSE) / S_DQ_PRECLOSE, 6) as S_DQ_PERCENT")
                                    .orderBy("S_INFO_WINDCODE", "TRADE_DT").as(StockRecordEncoder);
        //test.show(500);

        List<StockRecord> stockRecords = test.collectAsList();
//        for(StockRecord stockRecord : stockRecords)
//        {
//            System.out.println(stockRecord);
//        }

        try
        {
            File file = new File("E:\\Idea\\SparkTest\\src\\2015.txt");
            //将list写入文件
            Writer out = new FileWriter(file);
            BufferedWriter bw= new BufferedWriter(out);
            for(StockRecord s:stockRecords) {
                bw.write(String.valueOf(s));
                bw.newLine();
                bw.flush();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
