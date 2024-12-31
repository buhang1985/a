package iih.ei.std.d.v1.bd.comm.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface QueryNodeListType {

    @DmEnumDesc(name="AND",description="AND")
    public static final String AND="01"; //AND
    @DmEnumDesc(name="OR",description="OR")
    public static final String OR="02"; //OR
}	
