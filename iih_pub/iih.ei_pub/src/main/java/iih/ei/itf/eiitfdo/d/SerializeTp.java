package iih.ei.itf.eiitfdo.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SerializeTp {

    @DmEnumDesc(name="xml格式",description="xml格式")
    public static final String XML="1"; //xml格式
    @DmEnumDesc(name="json格式",description="json格式")
    public static final String JSON="2"; //json格式
}	
