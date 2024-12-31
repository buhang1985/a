package iih.mm.pl.poplanstrategy.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface POSUPTYPE {

    @DmEnumDesc(name="最近采购供应商",description="最近采购供应商")
	public static final Integer POSUP_LAST=1; //最近采购供应商
    @DmEnumDesc(name="协议采购供应商",description="协议采购供应商")
	public static final Integer POSUP_PROTOCL=2; //协议采购供应商
}	
