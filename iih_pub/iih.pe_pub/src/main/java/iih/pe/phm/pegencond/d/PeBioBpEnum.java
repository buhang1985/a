package iih.pe.phm.pegencond.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeBioBpEnum {

    @DmEnumDesc(name="正常血压",description="收缩压小于120 且 舒张压小于80")
	public static final Integer PEBIOBPNORMAL=1; //正常血压
    @DmEnumDesc(name="正常高值",description="收缩压120~139 或 舒张压80~89")
	public static final Integer PEBIOBPHEIGHT=2; //正常高值
    @DmEnumDesc(name="1级高血压（较轻）",description="收缩压140~159 或 舒张压90~99")
	public static final Integer PEBIOBPHL1=3; //1级高血压（较轻）
    @DmEnumDesc(name="2级高血压（中度）",description="收缩压160~179 或 舒张压100~109")
	public static final Integer PEBIOBPHL2=4; //2级高血压（中度）
    @DmEnumDesc(name="3级高血压（重度）",description="收缩压大于等于180 或 舒张压大于等于110")
	public static final Integer PEBIOBPHL3=5; //3级高血压（重度）
    @DmEnumDesc(name="单纯收缩期高血压",description="收缩压大于等于140 且 舒张压小于90")
	public static final Integer PEBIOBPISH=6; //单纯收缩期高血压
}	
