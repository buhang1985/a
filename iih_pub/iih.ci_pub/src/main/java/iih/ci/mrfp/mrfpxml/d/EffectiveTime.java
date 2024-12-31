package iih.ci.mrfp.mrfpxml.d;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"low","high"})
public class EffectiveTime {
    private CValue low;
    private CValue high;
    @XmlElement( name ="low")
    public CValue getLow() { 
         return low;
    }
    @XmlElement( name ="high")
    public CValue getHigh() { 
         return high;
    }
    public  void setLow(CValue low) { 
         this.low = low;
    }
    public  void setHigh(CValue high) { 
         this.high = high;
    }
}
