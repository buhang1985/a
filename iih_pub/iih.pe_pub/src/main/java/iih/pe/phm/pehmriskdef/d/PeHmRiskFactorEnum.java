package iih.pe.phm.pehmriskdef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeHmRiskFactorEnum {

    @DmEnumDesc(name="基本资料",description="基本资料")
	public static final Integer PEHMRISKBASE=1; //基本资料
    @DmEnumDesc(name="检查结果",description="检查结果")
	public static final Integer PEHMRISKRESULT=2; //检查结果
    @DmEnumDesc(name="问卷",description="问卷")
	public static final Integer PEHMRISKSURVEY=3; //问卷
}	
