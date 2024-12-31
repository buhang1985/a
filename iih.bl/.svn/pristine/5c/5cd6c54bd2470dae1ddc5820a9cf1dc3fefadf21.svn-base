package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.cg.blcghist.s.bp.SaveCgIpHistBP;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.d.BlCgSelfPayDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 修改住院记账自费标识
 * @author hanjq 下午1:21:13
 *
 */
public class UpdateBlCgIpFgSelfPayBP {

	public void exec(BlCgSelfPayDTO[] dtos) throws BizException {
		check(dtos);
		List<BlCgIpDO> updatas = new ArrayList<>();
		DAFacade daf = new DAFacade();
		
		String sql = getSql(dtos);
		List<BlCgIpDO> cgIps = (List<BlCgIpDO>) daf.execQuery(sql, new BeanListHandler(BlCgIpDO.class));
		if(cgIps != null && cgIps.size() > 0){
			for (BlCgIpDO cg: cgIps) {
				if(StringUtils.isBlank(cg.getId_orsrv())){
					cg.setId_orsrv("~");
				}
				for(BlCgSelfPayDTO dto : dtos){
					if(dto.getId_ent().equals(cg.getId_ent()) && dto.getId_or().equals(cg.getId_or())
							&& dto.getId_orsrv().equals(cg.getId_orsrv())
							&& !dto.getFg_selfpay().equals(cg.getFg_selfpay())){
						cg.setFg_selfpay(dtos[0].getFg_selfpay());//否则使用传递过来的
						cg.setStatus(DOStatus.UPDATED);
						updatas.add(cg);
					}
					
				}
				
			}
		}
		
		if(updatas.size() > 0){
			SaveCgIpHistBP hisBp = new SaveCgIpHistBP();
			daf.updateDOArray(updatas.toArray(new BlCgIpDO[0]), new String []{BlCgIpDO.FG_SELFPAY});
			hisBp.saveHistory(updatas, "04","UpdateBlCgIpFgSelfPayBP");//临床医嘱修改
		}
	}
	
	private void check(BlCgSelfPayDTO[] dtos) throws BizException{
		if(dtos == null || dtos.length == 0){
			throw new BizException("参数为空");
		}
		
		for(BlCgSelfPayDTO dto : dtos){
			if(dto == null){
				throw new BizException("参数为空");
			}
			
			if(StringUtils.isBlank(dto.getId_ent())){
				throw new BizException("就诊主键为空");
			}
			
			if(StringUtils.isBlank(dto.getId_or())){
				throw new BizException("医嘱为空");
			}
			if(dto.getFg_orhp() == null){
				throw new BizException("医嘱医保标识为空");
			}
			
			if(StringUtils.isBlank(dto.getSd_hpsrvtp())){
				throw new BizException("医嘱服务项目等级为空");
			}
		}
	}
	
	private String getSql(BlCgSelfPayDTO[] dtos){
		HashSet<String> idEnts = new HashSet<>();
		HashSet<String> idOrs = new HashSet<>();
		HashSet<String> idOrSrvs = new HashSet<>();
		HashSet<String> fgSelfPays = new HashSet<>();
		StringBuilder bd = new StringBuilder();
		bd.append("select * from bl_cg_ip where 1=1 ");
		for(BlCgSelfPayDTO dto:dtos){
			idEnts.add(dto.getId_ent());
			idOrs.add(dto.getId_or());
			if(StringUtils.isBlank(dto.getId_orsrv())){
				dto.setId_orsrv("~");
				idOrSrvs.add("~");
			}else{
				idOrSrvs.add(dto.getId_orsrv());
			}
			//查出相反的
			String fgSelfPay = FBoolean.TRUE.equals(dto.getFg_selfpay()) ? "N":"Y";
			fgSelfPays.add(fgSelfPay);
		}
		bd.append(" and ");
		setStringBuilder(bd, idEnts.toArray(new String[0]), "id_ent");
		setStringBuilder(bd, idOrs.toArray(new String[0]), "id_or");
		setStringBuilder(bd, idOrSrvs.toArray(new String[0]), "id_orsrv");
		setStringBuilder(bd, fgSelfPays.toArray(new String[0]), "fg_selfpay");
		
		return bd.toString();		
	}
	
	private void setStringBuilder(StringBuilder bd , String[] idStrs , String name){
		int size = idStrs.length;
		bd.append(name);
		if(size == 1){
			bd.append(" = '").append(idStrs[0]).append("' ");			
		}else{
			String douHao = "";
			bd.append(" in ( ");
			for(String str : idStrs){
				bd.append(douHao).append("'").append(str).append("'");
				douHao = " , ";
			}
			bd.append(" ) ");
		}		
	}
}
