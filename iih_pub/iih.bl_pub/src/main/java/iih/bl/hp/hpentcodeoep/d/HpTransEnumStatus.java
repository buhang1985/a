package iih.bl.hp.hpentcodeoep.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpTransEnumStatus {

    @DmEnumDesc(name="医保交易成功",description="医保交易成功")
    public static final String FG_HP_SUCC="01"; //医保交易成功
    @DmEnumDesc(name="医保交易失败",description="医保交易失败")
    public static final String FG_HP_FAIL="02"; //医保交易失败
    @DmEnumDesc(name="银行交易成功",description="银行交易成功")
    public static final String FG_BANK_SUCC="03"; //银行交易成功
    @DmEnumDesc(name="银行交易失败",description="银行交易失败")
    public static final String FG_BANK_FAIL="04"; //银行交易失败
}	
