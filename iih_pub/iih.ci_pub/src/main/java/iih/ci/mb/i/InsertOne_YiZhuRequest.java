package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InsertOne_YiZhuRequest
{
    @JsonProperty(value = "yiZhu")
    private ArrayOfYZInsertParameters yiZhu;

    public void setYiZhu(ArrayOfYZInsertParameters yiZhu)
    {
        this.yiZhu = yiZhu;
    }
    public ArrayOfYZInsertParameters getYiZhu()
    {
        return this.yiZhu;
    }
}
