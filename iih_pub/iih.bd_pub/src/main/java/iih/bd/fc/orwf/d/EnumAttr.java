package iih.bd.fc.orwf.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumAttr {

    @DmEnumDesc(name="服务分类",description="服务分类")
	public static final Integer SRVCA=1; //服务分类
    @DmEnumDesc(name="医疗服务",description="医疗服务")
	public static final Integer SRV=2; //医疗服务
    @DmEnumDesc(name="用法",description="用法")
	public static final Integer ROUTE=3; //用法
    @DmEnumDesc(name="剂型",description="剂型")
	public static final Integer DOSAGE=4; //剂型
    @DmEnumDesc(name="毒麻",description="毒麻")
	public static final Integer POSI=5; //毒麻
    @DmEnumDesc(name="物品",description="物品")
	public static final Integer MM=6; //物品
    @DmEnumDesc(name="开单科室",description="开单科室")
	public static final Integer DEPOR=7; //开单科室
    @DmEnumDesc(name="就诊科室",description="就诊科室")
	public static final Integer DEPPHY=8; //就诊科室
    @DmEnumDesc(name="护理单元",description="护理单元")
	public static final Integer DEPNUR=9; //护理单元
    @DmEnumDesc(name="星期",description="星期")
	public static final Integer WEEK=10; //星期
    @DmEnumDesc(name="周期类型",description="周期类型")
	public static final Integer LONG=11; //周期类型
    @DmEnumDesc(name="草药制剂",description="草药制剂")
	public static final Integer HERBPERP=12; //草药制剂
    @DmEnumDesc(name="服务类型",description="服务类型")
	public static final Integer SRVTP=13; //服务类型
    @DmEnumDesc(name="领药方式",description="领药方式")
	public static final Integer MEDI=14; //领药方式
    @DmEnumDesc(name="年龄等级",description="年龄等级")
	public static final Integer AGELEVEL=15; //年龄等级
    @DmEnumDesc(name="录入科室",description="录入科室")
	public static final Integer DEPRECORD=16; //录入科室
}	
