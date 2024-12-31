package iih.sfda.aer.sfdaaerevddrug.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnMedicineEnum {

    @DmEnumDesc(name="是",description="是")
	public static final Integer YES=1; //是
    @DmEnumDesc(name="否",description="否")
	public static final Integer NOT=2; //否
    @DmEnumDesc(name="不明",description="不明")
	public static final Integer NOTCLEAR=3; //不明
    @DmEnumDesc(name="未停药或未减量",description="未停药或未减量")
	public static final Integer NOTMEDICINE=4; //未停药或未减量
}	
