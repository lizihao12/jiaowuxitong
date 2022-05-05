import xlwt
from selenium import webdriver
# 加载驱动
driver=webdriver.Chrome()
# 用驱动打开淘宝
driver.get('https://www.saihuan.net/')
# 通过获取输入框的的id来获取节点
workbook = xlwt.Workbook(encoding='utf-8')  # 创建workbook对象(可以理解为是一个文件）
worksheet = workbook.add_sheet('sheet1') #创建工作表（可以理解为该文件中的一个表单）
worksheet.write(0,0,"图片")
worksheet.write(0,1,"赛事类型")
worksheet.write(0,2,"时间")
worksheet.write(0,3,"赛事名称")
worksheet.write(0,4,"赛事描述")
a=0
s=driver.find_element_by_id('itemContainer')
for i in s.find_elements_by_xpath('//*[@class="article-item"]'):
    more_box = driver.find_element_by_class_name("more_box")
    driver.execute_script('window.scrollTo(0,document.body.scrollHeight)')
    more_box.click()
    a=a+1
    for j in range(5):
        if j==0:
            worksheet.write(a, j, i.find_element_by_class_name("img-cover").find_element_by_tag_name('img').get_attribute('src'))
        elif j==1:
            worksheet.write(a, j,i.find_element_by_class_name("article-info").find_element_by_class_name("category-tag").text)
        elif j==2:
            worksheet.write(a, j,i.find_element_by_class_name("article-info").find_element_by_class_name("article-time").text)
        elif j==3:
            worksheet.write(a, j, i.find_element_by_class_name("article-info").find_element_by_tag_name("h3").text)
        elif j == 4:
            worksheet.write(a, j, i.find_element_by_class_name("article-info").find_element_by_tag_name("p").text)
workbook.save("data.xls") #保存数据表
driver.close()
