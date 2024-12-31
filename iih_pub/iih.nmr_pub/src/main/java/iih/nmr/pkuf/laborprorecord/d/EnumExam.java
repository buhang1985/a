package iih.nmr.pkuf.laborprorecord.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumExam {

    @DmEnumDesc(name="无",description="无")
	public static final Integer NOTHING=0; //无
    @DmEnumDesc(name="有",description="有")
	public static final Integer HAVE=1; //有
}	
