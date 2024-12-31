package iih.bd.pp.hpdivshisdto.s.bp;

import java.util.LinkedList;
import java.util.List;

import iih.bd.pp.hpdidict.d.HpDiDictDO;
import iih.bd.pp.hpdidictah.d.HpDiDictAhDO;
import iih.bd.pp.hpdivshis.d.HpDiVsHisDO;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * HpDiVsHisDTO删除Bp
 * @author guoyang
 *
 */
public class HpDiVsHisDtoDeleteBp {

	public void exec(HpDiVsHisDTO[] hpDiVsHisDTOs) throws DAException{
		if(hpDiVsHisDTOs != null && hpDiVsHisDTOs.length > 0){
			List<String> hpDiDictDOPks = new LinkedList<String>();
			List<String> hpDiDictAhDOPks = new LinkedList<String>();
			List<String> hpDiVsHisDOPks = new LinkedList<String>();
			for (int i = 0; i < hpDiVsHisDTOs.length; i++) {
				if(hpDiVsHisDTOs[i].getId_hpdidict() != null){
					hpDiDictDOPks.add(hpDiVsHisDTOs[i].getId_hpdidict());
					hpDiDictAhDOPks.add(hpDiVsHisDTOs[i].getId_hpdidict());
				}
				if(hpDiVsHisDTOs[i].getId_hpdivshis() != null){
					hpDiVsHisDOPks.add(hpDiVsHisDTOs[i].getId_hpdivshis());
				}
			}
			new DAFacade().deleteByPKs(HpDiDictDO.class, hpDiDictDOPks.toArray(new String[hpDiDictDOPks.size()]));
			new DAFacade().deleteByPKs(HpDiDictAhDO.class, hpDiDictAhDOPks.toArray(new String[hpDiDictAhDOPks.size()]));
			new DAFacade().deleteByPKs(HpDiVsHisDO.class, hpDiVsHisDOPks.toArray(new String[hpDiVsHisDOPks.size()]));
		}
	}
}
