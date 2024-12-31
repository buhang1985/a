package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class AddPatientNoteRequest
{
    @JsonProperty(value = "entity")
    private Note_Patient entity;
    @JsonProperty(value = "PicturePath")
    private ArrayOfString PicturePath;
    @JsonProperty(value = "VoicePath")
    private ArrayOfString VoicePath;

    public void setEntity(Note_Patient entity)
    {
        this.entity = entity;
    }
    public Note_Patient getEntity()
    {
        return this.entity;
    }
    public void setPicturePath(ArrayOfString PicturePath)
    {
        this.PicturePath = PicturePath;
    }
    public ArrayOfString getPicturePath()
    {
        return this.PicturePath;
    }
    public void setVoicePath(ArrayOfString VoicePath)
    {
        this.VoicePath = VoicePath;
    }
    public ArrayOfString getVoicePath()
    {
        return this.VoicePath;
    }
}
