# cloudMusic
the selenium spider for cloudMusic

selenium 的驱动文件放置在drivers下
# 关于如何使用
使用的springboot框架,等待maven把包下好,项目编译完毕,
直接启动CloudApplication类即可,我使用的是定时任务来抓取网易云,目前设置一小时抓取一次,可以自行修改,
定时任务文件夹在 schedule下<br>
当然我此版本的maven插件我也都配好了,你可以直接打成jar包 使用 java -jar 来启动打包好项目

# 关于IE浏览器的配置
如果你想要使用IE浏览器驱动你需要配置,目前代码里只有Chrome的逻辑,你可以自行添加<br>
![IE](https://upload-images.jianshu.io/upload_images/6213878-d45123a4cb1c2ab6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/386)

Chrome浏览器的相关问题

首先的你必须有安装Chrome浏览器(官方版)<br>
我这里使用的驱动版本为2.40,支持v66-68,如果你的谷歌浏览器版本较低请升级<br>
当然,也可以下载低版本的驱动替换 https://npm.taobao.org/mirrors/chromedriver<br>
对应Chrome浏览器的版本表:<br>
<table>
    <tr>
        <th>驱动版本</th>
        <th>Chrome版本</th>
    </tr>
    <tr>
        <th>v2.38</th>
        <th>v65-v67</th>
    </tr>
    <tr>
        <th>v2.37</th>
        <th>v64-v66</th>
    </tr>
    <tr>
        <th>v2.36</th>
        <th>v63-v65</th>
    </tr>
    <tr>
        <th>v2.35</th>
        <th>v62-v64</th>
    </tr>
    <tr>
        <th>v2.34</th>
        <th>v61-v63</th>
    </tr>
    <tr>
        <th>v2.21</th>
        <th>v46-v50</th>
    </tr>
</table>
其他版本太多了,不一一举例了
目前设定的是每一小时自动跑一次,定时类在 schedule文件夹下,可以自行更改时间

