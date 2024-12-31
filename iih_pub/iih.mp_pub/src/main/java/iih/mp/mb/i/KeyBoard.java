package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class KeyBoard
{
    @JsonProperty(value = "KeyboardId")
    private Integer KeyboardId;
    @JsonProperty(value = "KeyboardName")
    private String KeyboardName;
    @JsonProperty(value = "KeyboardType")
    private String KeyboardType;
    @JsonProperty(value = "JumpCondition")
    private String JumpCondition;
    @JsonProperty(value = "Min")
    private Double Min;
    @JsonProperty(value = "Max")
    private Double Max;
    @JsonProperty(value = "Pages")
    private String Pages;

    /**
     * 自定义键盘用来区分档案还是枚举
     */
    @JsonProperty(value = "UdiOrEnum")
    private String UdiOrEnum;
    
    public String getUdiOrEnum() {
		return UdiOrEnum;
	}
	public void setUdiOrEnum(String udiOrEnum) {
		UdiOrEnum = udiOrEnum;
	}
	@JsonProperty(value = "types")
    private byte[] types;
    
    public void setKeyboardId(Integer KeyboardId)
    {
        this.KeyboardId = KeyboardId;
    }
    public Integer getKeyboardId()
    {
        return this.KeyboardId;
    }
    public byte[] getType() {
		return types;
	}
	public void setType(byte[] types) {
		this.types = types;
	}
	public void setKeyboardName(String KeyboardName)
    {
        this.KeyboardName = KeyboardName;
    }
    public String getKeyboardName()
    {
        return this.KeyboardName;
    }
    public void setKeyboardType(String KeyboardType)
    {
        this.KeyboardType = KeyboardType;
    }
    public String getKeyboardType()
    {
        return this.KeyboardType;
    }
    public void setJumpCondition(String JumpCondition)
    {
        this.JumpCondition = JumpCondition;
    }
    public String getJumpCondition()
    {
        return this.JumpCondition;
    }
    public void setMin(Double Min)
    {
        this.Min = Min;
    }
    public Double getMin()
    {
        return this.Min;
    }
    public void setMax(Double Max)
    {
        this.Max = Max;
    }
    public Double getMax()
    {
        return this.Max;
    }
    public void setPages(String Pages)
    {
        this.Pages = Pages;
    }
    public String getPages()
    {
        return this.Pages;
    }
}
