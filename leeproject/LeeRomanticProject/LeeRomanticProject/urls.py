"""LeeRomanticProject URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.8/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
from django.conf.urls import include, url
from django.contrib import admin #admin
from apptrain import views as learn_views # change default views name;

urlpatterns = [
    url(r'^admin/', include(admin.site.urls)),
	url(r'^$',learn_views.index),
	url(r'^index/',learn_views.index,name='index'),
	url(r'^add/(\d+)/(\d+)/$',learn_views.add,name = 'add'),
	url(r'^home/',learn_views.home,name='home'),
	url(r'^addPeople/',learn_views.addPeople,name='addPeople'),
    url(r'^findInfos/',learn_views.findInfos,name='findInfos'),
    url(r'^hello/',learn_views.hello),
    url(r'^helloPost/',learn_views.helloPost,name='helloPost'),
]
