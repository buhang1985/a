package iih.pe.pps.peivs.peivhypertension.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeHypertensionLevelEnum {

    @DmEnumDesc(name="一级",description="一级")
	public static final Integer PEHYPERTENSLEVEL1=1; //一级
    @DmEnumDesc(name="二级",description="二级")
	public static final Integer PEHYPERTENSLEVEL2=2; //二级
    @DmEnumDesc(name="三级",description="三级")
	public static final Integer PEHYPERTENSLEVEL3=3; //三级
}	
