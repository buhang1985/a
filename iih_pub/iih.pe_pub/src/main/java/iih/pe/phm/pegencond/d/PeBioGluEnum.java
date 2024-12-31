package iih.pe.phm.pegencond.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeBioGluEnum {

    @DmEnumDesc(name="正常",description="空腹：小于5.6 或 餐后2h血糖 小于6.7")
	public static final Integer PEBIOGLUNORMAL=1; //正常
    @DmEnumDesc(name="空腹血糖受损（IFG）",description="空腹：5.6 ~ 6.1 或 餐后2h血糖 小于6.7")
	public static final Integer PEBIOGLUDEMAGE=2; //空腹血糖受损（IFG）
    @DmEnumDesc(name="糖耐量减低（IGT）",description="空腹：小于6.1  且 或 餐后2h血糖 6.7 ~ 10.1")
	public static final Integer PEBIOGLULOW=3; //糖耐量减低（IGT）
    @DmEnumDesc(name="糖尿病",description="空腹：大于等于6.1 或 餐后2h血糖 大于等于10.0")
	public static final Integer PEBIOGLUDIABETES=4; //糖尿病
}	
