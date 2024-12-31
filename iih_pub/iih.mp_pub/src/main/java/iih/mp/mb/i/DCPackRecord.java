package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPackRecord
{
    @JsonProperty(value = "box_code")
    private String box_code;
    @JsonProperty(value = "group_no")
    private String group_no;
    @JsonProperty(value = "receipt_opera")
    private String receipt_opera;
    @JsonProperty(value = "receipt_flag")
    private String receipt_flag;

    public void setBox_code(String box_code)
    {
        this.box_code = box_code;
    }
    public String getBox_code()
    {
        return this.box_code;
    }
    public void setGroup_no(String group_no)
    {
        this.group_no = group_no;
    }
    public String getGroup_no()
    {
        return this.group_no;
    }
    public void setReceipt_opera(String receipt_opera)
    {
        this.receipt_opera = receipt_opera;
    }
    public String getReceipt_opera()
    {
        return this.receipt_opera;
    }
    public void setReceipt_flag(String receipt_flag)
    {
        this.receipt_flag = receipt_flag;
    }
    public String getReceipt_flag()
    {
        return this.receipt_flag;
    }
}
