package iih.ci.mr.cimrfs.s;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrfs.i.ICimrPrintService;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取替换的病历模板流
 */
@Service(serviceInterfaces={ICimrPrintService.class}, binding=Binding.JSONRPC)
public class CimrPrintServiceImpl implements ICimrPrintService {

	@Override
	public CiMrFsDO[] getCimrStream(CiMrDO[] dos)
			throws BizException {
		if(dos==null) return null;
		StringBuffer str=new StringBuffer("'");
		StringBuffer str2=new StringBuffer("'");
		for(int i=0;i<dos.length;i++)
		{
			if(i!=dos.length-1)
			{
				str.append(dos[i].getId_mr()+"','");
				str2.append(dos[i].getId_mr()+",");
			}else
			{
				str.append(dos[i].getId_mr()+"'");
				str2.append(dos[i].getId_mr()+"',id_mr");
			}
		}
//		String sql= "select * from CI_MR_FS where id_mr in("+str+")";
		String sql= "select * from CI_MR_FS where id_mr in("+str+") order by instr ("+str2+")";
       //'0001AA10000000071WGR','0001AA10000000071WGP','0001AA10000000071WGN','0001AA10000000071WGL','0001AA10000000071WGJ','0001AA10000000071WGH','0001AA10000000071WGF','0001AA10000000071WGD','0001AA10000000071WGB','0001AA1000000006UFWX'
	   //String sql= "select * from CI_MR_FS where id_mr in('0001AA10000000071WGP')";
		List<CiMrFsDO> list= (List<CiMrFsDO>)new DAFacade().execQuery(sql, new BeanListHandler(CiMrFsDO.class));
		if(list.size()>0) return list.toArray(new CiMrFsDO[0]);
		return null;
	}

}
