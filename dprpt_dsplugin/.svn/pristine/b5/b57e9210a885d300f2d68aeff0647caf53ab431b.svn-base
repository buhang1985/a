1. 本工程为报表设计和运行过程中Java对象数据集提供支持，在中间件中启动前：
   - 使用XapTools下载最新的xap.report发布包
   - 添加一个XAP Runtime启动项，命名feature_report，
               勾选xap.report, xap.middware_xxx, system三项
   - 启动feature_report

2. 本工程不能单独发布，需要先通过svn同步到固定的发布者本地，然后和报表服务一起进行Deploy
   - 本地调试不受影响

3. 因为所有涉及Java对象数据集的业务开发都在这个工程里，添加JavaBean之前，建好自己的package名称(可以和iih同包名)

4. 对原有BaseDO/BaseDTO对象的支持，参考代码：
   - test.iih.bl.cg，其中BlcgqueryServiceImpl是普通类，不需要以原服务形式存在
   - 报表示例：Xap_Report_Fold.zip\rpttempl\qys_test\JavaBeanDS.xml
   
5. 对报表特定JavaBean对象的支持，参考代码：
   - test.rptbean
     - Person 类列表作为 Student 的子表对象存在
       
   - xap.dp.report.dsplugin.base
     - IRptBaseBean 接口是JavaBean的超级接口，提供过滤和清除功能
     - RptBaseBeanList 类封装一个IRptBaseBean列表，提供add, sort等功能
     
   - 报表示例：Xap_Report_Fold.zip\rpttempl\qys_test\JavaBeanDS.xml

6. 本地启动设计器入口
   - test.rptapp.RunDesigner
   
7. 报表服务器的当前用户目录中，设计了一个标识文件：_xap_dev_rptserv_
    - 如果没有这个文件，报表服务启动的时候会自动清空本地报表模板目录：/{user}/xap.dp.report，这样访问报表时就会自动去文件系统下载了
    - 一般开发版公共报表服务上有这个标识文件，本地保留一份报表模板，以防万一
    
