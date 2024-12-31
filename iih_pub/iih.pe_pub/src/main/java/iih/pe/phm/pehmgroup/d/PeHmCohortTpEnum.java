package iih.pe.phm.pehmgroup.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeHmCohortTpEnum {

    @DmEnumDesc(name="干预组",description="干预组")
	public static final Integer PEHMCOHORTTREATMENTGROUP=1; //干预组
    @DmEnumDesc(name="对照组",description="对照组")
	public static final Integer PEHMCOHORTCONTROLGROUP=2; //对照组
}	
