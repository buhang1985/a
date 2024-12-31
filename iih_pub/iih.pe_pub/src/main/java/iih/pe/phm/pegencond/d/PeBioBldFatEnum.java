package iih.pe.phm.pegencond.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeBioBldFatEnum {

    @DmEnumDesc(name="正常",description="胆固醇：小于5.20 ，且 低密度：小于3.12， 且 高密度：大于等于1.04，且 甘油三脂：小于1.65")
	public static final Integer PEBIOBLDFATNORMAL=1; //正常
    @DmEnumDesc(name="边缘升高",description="胆固醇：5.20~6.20，或 低密度：3.12~4.13，或 甘油三脂：1.65~2.19")
	public static final Integer PEBIOBLDFATEDGEHEIGHT=2; //边缘升高
    @DmEnumDesc(name="升高",description="胆固醇：大于等于6.21，或 低密度：大于等于4.14，或 甘油三脂：大于2.20")
	public static final Integer PEBIOBLDFATHEIGHT=3; //升高
    @DmEnumDesc(name="降低",description="高密度：小于1.04")
	public static final Integer PEBIOBLDFATLOW=4; //降低
}	
