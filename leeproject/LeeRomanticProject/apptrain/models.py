from django.db import models

# Create your models here.
class People(models.Model):
	name = models.CharField(max_length=30)
	age = models.IntegerField()
	def __unicode__(self):
		return self.name;

		
class Blog(models.Model):
	name = models.CharField(max_length = 100)
	tagline = models.TextField()
	
	def __unicode__(self): #__str__ on Python 3
		return self.name;
		
class Author(models.Model):
	name = models.CharField(max_length=50)
	email = models.EmailField()
	
	def __unicode__(self):   #__str__ on python 3
		return self.name;
		
class Entry(models.Model):
	blog = models.ForeignKey(Blog)
	headline = models.CharField(max_length=255)
	body_text = models.TextField()
	pub_date = models.DateField()
	mod_date = models.DateField()
	authors = models.ManyToManyField(Author)
	n_comments = models.IntegerField()
	n_pingbacks = models.IntegerField()
	rating = models.IntegerField()
	
	def __unicode__(self):   #__str__ on python 3
		return self.headline


class Mysite(models.Model):

	title = models.CharField(max_length=100)
	url = models.URLField()
	author = models.CharField(max_length =100)
	num = models.IntegerField()

from django.contrib import admin
class BlogsPost(models.Model):
	title = models.CharField(max_length=150)
	body = models.TextField()
	timestamp = models.DateTimeField()
	def  __unicode__(self):
		return self.title
class BlogPostAdmin(admin.ModelAdmin):
	list_display = ('title','timestamp')
admin.site.register(BlogsPost,BlogPostAdmin)