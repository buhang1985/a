package iih.pe.pitm.penhcposi.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeNhcPosiSumEnum {

    @DmEnumDesc(name="是",description="是")
	public static final Integer PESUMYES=1; //是
    @DmEnumDesc(name="否",description="否")
	public static final Integer PESUMNO=2; //否
    @DmEnumDesc(name="全部",description="全部")
	public static final Integer PESUMALL=3; //全部
}	
