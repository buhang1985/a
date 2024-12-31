package iih.bd.fc.orderlooptype.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.fc.ormatchorpltp.d.SrvtpTreeDTO;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年9月2日 下午8:26:55
 * 类说明 查询服务类型树
 */
public class GetSrvtpTreeDTOBp {
	public SrvtpTreeDTO[] exec() throws BizException{
		
		//1.查询出所有的服务类型
		IUdidocServiceExt serviceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = serviceExt.findByUdidoclistCode("BD.SRV.0505");
		
		//2.查询服务类型下的闭环条数拼装树dto
		SrvtpTreeDTO[] treeDTOs=getSrvtpTreeDTO(udidocDOs);
		return treeDTOs;
	}
	
	/**
	 * 查询服务类型下的闭环条数拼装树dto
	 * @param udidocDOs
	 * @return
	 * @throws BizException
	 */
	private SrvtpTreeDTO[] getSrvtpTreeDTO(UdidocDO[] udidocDOs) throws BizException{
		
		
		List<SrvtpTreeDTO> list = new ArrayList<SrvtpTreeDTO>();
		IOrpltpmtparaRService service = ServiceFinder.find(IOrpltpmtparaRService.class);
//		OrpltpmtParaDO[] staDOs=service.find("a0.sd_srvtp  like '"+udidocDO.getCode()+"%'", "", FBoolean.FALSE);
		OrpltpmtParaDO[] staDOs = service.find(" 1=1 ", "", FBoolean.FALSE);
		List<String> srvtpList = new ArrayList<String>();
		if (staDOs!=null && staDOs.length>0) {
			for (OrpltpmtParaDO orpltpmtParaDO : staDOs) {
				String[] str=orpltpmtParaDO.getSd_srvtps().split(",");
				srvtpList.addAll(Arrays.asList(str));
			}
		}
		
		for (UdidocDO udidocDO : udidocDOs) {
			int count = 0;
			SrvtpTreeDTO dto = new SrvtpTreeDTO();
			dto.setId_srvtp(udidocDO.getId_udidoc());
			dto.setCode(udidocDO.getCode());
			dto.setId_par(udidocDO.getId_parent());
			if(srvtpList.size()>0){
				for (String string : srvtpList) {
					if(string.startsWith(udidocDO.getCode())){
						count++;
					}
				}
			}
			dto.setNumber(count);
			dto.setName(udidocDO.getName()+"("+count+")");
			list.add(dto);
		}
		
		return list.toArray(new SrvtpTreeDTO[list.size()]);
	}
}

