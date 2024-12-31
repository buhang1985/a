package iih.pe.pwf.perstimg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRstFileTpEnum {

    @DmEnumDesc(name="图片JPG",description="图片JPG")
	public static final Integer PEJPEG=1; //图片JPG
    @DmEnumDesc(name="图片PNG",description="图片PNG")
	public static final Integer PEPNG=2; //图片PNG
    @DmEnumDesc(name="图片GIF",description="图片GIF")
	public static final Integer PEGIF=3; //图片GIF
}	
