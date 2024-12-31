package iih.bd.fc.dto.shortselect.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDataTp {

    @DmEnumDesc(name="服务",description="服务")
	public static final Integer SRV=1; //服务
    @DmEnumDesc(name="服务分类",description="服务分类")
	public static final Integer SRVCA=2; //服务分类
    @DmEnumDesc(name="剂型",description="剂型")
	public static final Integer DOSAGE=3; //剂型
    @DmEnumDesc(name="毒麻",description="毒麻")
	public static final Integer POSI=4; //毒麻
    @DmEnumDesc(name="物品",description="物品")
	public static final Integer MM=5; //物品
    @DmEnumDesc(name="部门",description="部门")
	public static final Integer DEP=6; //部门
    @DmEnumDesc(name="用法",description="用法")
	public static final Integer ROUTE=7; //用法
    @DmEnumDesc(name="不计费类型",description="不计费类型")
	public static final Integer NODISPEN=8; //不计费类型
    @DmEnumDesc(name="药单类型",description="药单类型")
	public static final Integer SHETP=9; //药单类型
    @DmEnumDesc(name="就诊类型",description="就诊类型")
	public static final Integer ENTP=10; //就诊类型
    @DmEnumDesc(name="服务类型",description="服务类型")
	public static final Integer SRVTP=11; //服务类型
    @DmEnumDesc(name="年龄等级",description="年龄等级")
	public static final Integer AGELEVEL=12; //年龄等级
}	
