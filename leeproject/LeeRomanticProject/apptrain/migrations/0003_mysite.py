# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('apptrain', '0002_author_blog_entry'),
    ]

    operations = [
        migrations.CreateModel(
            name='Mysite',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('title', models.CharField(max_length=100)),
                ('url', models.URLField()),
                ('author', models.CharField(max_length=100)),
                ('num', models.IntegerField()),
            ],
        ),
    ]
