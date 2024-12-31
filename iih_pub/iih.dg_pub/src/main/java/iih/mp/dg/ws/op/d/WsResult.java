package iih.mp.dg.ws.op.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface WsResult {

    @DmEnumDesc(name="成功",description="")
	public static final Integer SUCC=0; //成功
    @DmEnumDesc(name="错误",description="")
	public static final Integer ERR=1; //错误
}	
