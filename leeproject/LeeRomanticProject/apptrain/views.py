#coding:utf-8
from django.shortcuts import render,render_to_response
from django.http import HttpResponse

#forms
from apptrain.models import *
from apptrain.forms import *
from django.template import RequestContext 


# Create your views here.
def index(request):
	blog_list = BlogsPost.objects.all()
	return render_to_response('index.html',{'blog_list':blog_list})
	# a = request.GET['a']
	# b = request.GET['b']
	# c = int(a)+int(b)
	# return HttpResponse(u'hello index')
def add(request, a, b):
#	a = request.GET['a']
#	b = request.GET['b']
#	c = int(a)+int(b)
	
	return HttpResponse(u'hello')
def home(request):
#	string = u'I am learning about python django'
#	return render(request,'home1.html',{'string':string});
#	tutoriallist =['html','css','jquery','python','django']
#	return render(request,'home1.html',{'tutoriallist':tutoriallist})
#	info_dict = {'title':u'xiaowei','content':u'neirong'}
#	return render(request,'home1.html',{'info_dict':info_dict})
	list = map(str,range(0))#list 100
	return render(request,'apptrain/statichome.html',{'list':list})
#def homelist(request):

def addPeople(request):
#	name1 = request.GET['name']
#	age1 = request.GET['age']
#	people=People(name=name1,age=age1)
#	people.save()
#	p1 = People.objects.get(name=name1)
	Author.objects.create(name = 'jinyong1',email='hello@qq.com')
	name2 =Author.objects.get(name='jinyong1').name
	return HttpResponse(str(name2));
def findInfos(request):


	return render(request,'home.html')

def hello(request):
	if request.method == 'POST':
		return render_to_response('home.html')
	return render_to_response('home.html')
def helloPost(request):
	if 'age' in request.POST:
		message = request.POST['age'];
	else:
		message = 'there is no name ,please check again!!!'
	return render_to_response('apptrain/statichome.html',{'message':message})




