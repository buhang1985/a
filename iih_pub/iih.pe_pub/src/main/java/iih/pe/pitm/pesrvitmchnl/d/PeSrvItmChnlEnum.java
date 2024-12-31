package iih.pe.pitm.pesrvitmchnl.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeSrvItmChnlEnum {

    @DmEnumDesc(name="身高",description="身高")
	public static final Integer PECHNLHEIGHT=1; //身高
    @DmEnumDesc(name="体重",description="体重")
	public static final Integer PECHNLWEIGHT=2; //体重
    @DmEnumDesc(name="体重指数",description="体重指数")
	public static final Integer PECHNLBMI=3; //体重指数
    @DmEnumDesc(name="理想体重",description="理想体重")
	public static final Integer PECHNLIDEAWEIGHT=4; //理想体重
    @DmEnumDesc(name="收缩压",description="收缩压")
	public static final Integer PECHNLSBP=5; //收缩压
    @DmEnumDesc(name="舒张压",description="舒张压")
	public static final Integer PECHNLDBP=6; //舒张压
}	
