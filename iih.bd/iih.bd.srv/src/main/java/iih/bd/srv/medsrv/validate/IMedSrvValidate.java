package iih.bd.srv.medsrv.validate;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;

/// <summary>
/// <para>描    述 :                     			</para>
/// <para>说    明 :                     			</para>
/// <para>项目名称 :  iih.bd.srv.medsrv.validate    </para>    
/// <para>类 名 称 :  Interface1					</para> 
/// <para>版 本 号 :  v1.0.0.0           			</para> 
/// <para>作    者 :  qzwang         				</para> 
/// <para>修 改 人 :  qzwang         				</para> 
/// <para>创建时间 :  10/19/2016 8:58:22 PM             </para>
/// <para>更新时间 :  10/19/2016 8:58:22 PM             </para> 
/// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
/// </summary>
public interface IMedSrvValidate {
	public Boolean CheckValidate(MedSrvDO medsrv, List<BDErrorInfo> errorList)  throws BizException;
}
