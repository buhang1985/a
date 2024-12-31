package iih.bd.srv.emreditor.bp;

import java.util.List;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;

public class EmreditorCrudBp {
	
	public EmrEditorDO[] setCopyEmreditor(EmrEditorDO dos)
			throws BizException {    
		// TODO Auto-generated method stub   //点升级后调用
		EmrEditorDO  emrDO = dos;
		emrDO.setVer(null);
		emrDO.setSv((new FDateTime()));
		DAFacade cade = new DAFacade();
		if(emrDO.getActivestate()==2){
			emrDO.setActivestate(1);
		}
		 cade.insertDO(emrDO);
	 
		return null;
	}
	
	public EmrEditorDO[] setEnableCopyEmreditor(EmrEditorDO emr) 
			throws BizException {
		// TODO Auto-generated method stub   ，点启用后调用
		EmrEditorDO  emrDO = emr;
		String  code=emrDO.getCode();  //得到本分组的编码号，
	    if(emrDO.getVer()==null){
	    	emrDO.setVer(0);
		}
		Integer maxver=this.getBdmredMaxVersion(code);  //由编码号查出最大版本号
		emrDO.setVer(maxver);                     //将所选中节点的版本号置为最大版本号
		
		emrDO.setSv((new FDateTime()));
		DAFacade cade = new DAFacade();
		 cade.insertDO(emrDO);                 
		return null;
	}

	
	
	   //得到表bd_mred的最大版本号
		public Integer getBdmredMaxVersion(String code) throws BizException {
			// TODO Auto-generated method stub
			ColumnHandler handler = new ColumnHandler();
			StringBuffer sbf=new StringBuffer();
			sbf.append("select max(ver) from bd_mred where code='"+code+"'");
			DAFacade cade = new DAFacade();
			Integer ver = (Integer)cade.execQuery(sbf.toString(),handler);
			if(ver==null) return 0;
			else  return  ver;
		    
		}
		
		
		
				public EmrEditorDO[] getNewCopyDO(String code) throws BizException {
					// TODO Auto-generated method stub
					
					
					String sql="select * from bd_mred t where t.code='"+code+"'";
					
					List<EmrEditorDO> list= (List<EmrEditorDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrEditorDO.class));
					return list.toArray(new EmrEditorDO[0]);
				   
				}

	
	
	
}
