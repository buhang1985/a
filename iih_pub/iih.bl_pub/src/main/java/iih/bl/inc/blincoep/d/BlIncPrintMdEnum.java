package iih.bl.inc.blincoep.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BlIncPrintMdEnum {

    @DmEnumDesc(name="收款出票",description="")
    public static final String PRINTWHENCHARGE="01"; //收款出票
    @DmEnumDesc(name="窗口补打",description="")
    public static final String REPRINGBYWINDOW="02"; //窗口补打
    @DmEnumDesc(name="自助补打",description="")
    public static final String REPRINTBYSELF="03"; //自助补打
}	
