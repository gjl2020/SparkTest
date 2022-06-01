package spark;

import java.io.Serializable;

public class StockRecord implements Serializable {
    private String S_INFO_WINDCODE;
    private String TRADE_DT;
    private String S_DQ_PRECLOSE;
    private double S_DQ_CLOSE;
    private double S_DQ_PERCENT;

    public double getS_DQ_PERCENT() {
        return S_DQ_PERCENT;
    }

    public void setS_DQ_PERCENT(double s_DQ_PERCENT) {
        S_DQ_PERCENT = s_DQ_PERCENT;
    }

    public String getS_INFO_WINDCODE() {
        return S_INFO_WINDCODE;
    }

    public void setS_INFO_WINDCODE(String s_INFO_WINDCODE) {
        S_INFO_WINDCODE = s_INFO_WINDCODE;
    }

    public String getTRADE_DT() {
        return TRADE_DT;
    }

    public void setTRADE_DT(String TRADE_DT) {
        this.TRADE_DT = TRADE_DT;
    }

    public String getS_DQ_PRECLOSE() {
        return S_DQ_PRECLOSE;
    }

    public void setS_DQ_PRECLOSE(String s_DQ_PRECLOSE) {
        S_DQ_PRECLOSE = s_DQ_PRECLOSE;
    }

    public double getS_DQ_CLOSE() {
        return S_DQ_CLOSE;
    }

    public void setS_DQ_CLOSE(double s_DQ_CLOSE) {
        S_DQ_CLOSE = s_DQ_CLOSE;
    }

    @Override
    public String toString() {
        return "StockRecord{" +
                "S_INFO_WINDCODE='" + S_INFO_WINDCODE + '\'' +
                ", TRADE_DT='" + TRADE_DT + '\'' +
                ", S_DQ_PRECLOSE='" + S_DQ_PRECLOSE + '\'' +
                ", S_DQ_CLOSE=" + S_DQ_CLOSE +
                ", S_DQ_PERCENT=" + S_DQ_PERCENT +
                '}';
    }
}
