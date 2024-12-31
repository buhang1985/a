package iih.ci.test.utils;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CiWfServiceEnum {


    @DmEnumDesc(name="普药",description="普药")
	public static final String COMMONDRUG="commondrug"; //医生开立
}
