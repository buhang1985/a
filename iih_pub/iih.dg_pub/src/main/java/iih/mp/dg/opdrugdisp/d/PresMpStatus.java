package iih.mp.dg.opdrugdisp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PresMpStatus {

    @DmEnumDesc(name="未发药",description="未发药")
	public static final Integer DISP_NO=0; //未发药
    @DmEnumDesc(name="发药完成",description="发药完成")
	public static final Integer DISP_YES=1; //发药完成
    @DmEnumDesc(name="部分发药",description="部分发药")
	public static final Integer DISP_PARTIAL=2; //部分发药
}	
