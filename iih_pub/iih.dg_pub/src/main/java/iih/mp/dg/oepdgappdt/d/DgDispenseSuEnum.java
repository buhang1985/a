package iih.mp.dg.oepdgappdt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface DgDispenseSuEnum {

    @DmEnumDesc(name="未发药",description="未发药")
	public static final Integer UNDISPENSE=0;
    @DmEnumDesc(name="已发药",description="已发药")
	public static final Integer DISPENSED=1;
    @DmEnumDesc(name="发药完成",description="发药完成")
	public static final Integer COMPLETE=2;
    @DmEnumDesc(name="已退药",description="已退药")
	public static final Integer PHARMRTN=8;
    @DmEnumDesc(name="退药完成",description="退药退药完成")
	public static final Integer PHARMRTNOK=9;
}	
