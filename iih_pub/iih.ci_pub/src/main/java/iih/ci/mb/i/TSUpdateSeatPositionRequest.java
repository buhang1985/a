package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSUpdateSeatPositionRequest
{
    @JsonProperty(value = "seatID")
    private String seatID;
    @JsonProperty(value = "width")
    private Double width;
    @JsonProperty(value = "height")
    private Double height;
    @JsonProperty(value = "posX")
    private Double posX;
    @JsonProperty(value = "posY")
    private Double posY;

    public void setSeatID(String seatID)
    {
        this.seatID = seatID;
    }
    public String getSeatID()
    {
        return this.seatID;
    }
    public void setWidth(Double width)
    {
        this.width = width;
    }
    public Double getWidth()
    {
        return this.width;
    }
    public void setHeight(Double height)
    {
        this.height = height;
    }
    public Double getHeight()
    {
        return this.height;
    }
    public void setPosX(Double posX)
    {
        this.posX = posX;
    }
    public Double getPosX()
    {
        return this.posX;
    }
    public void setPosY(Double posY)
    {
        this.posY = posY;
    }
    public Double getPosY()
    {
        return this.posY;
    }
}
