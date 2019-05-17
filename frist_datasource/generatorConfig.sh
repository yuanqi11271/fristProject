#!/bin/bash
#File: generatorConfig.sh
#Auth: kevin.edison
#Date: 2016.03.15
#Desc: Using mybatis-generator to generate all the bean, xml mappers and mybatis xmls.
#      pls change the file with command:[chmod +x generateConfig.sh ] before using following commands
#com.iou.user.api
echo " ------ clear all the exists ------ "

path="com/yuanqi/datasource"

srcPath="target/generated-sources/mybatis-generator/${path}"

targetPath="src/main/java/${path}/"

#if [ ! -d "$srcPath/entity/" ]; then
#    mkdir -p "$srcPath/entity/"
#fi
#
#if [ ! -d "$srcPath/mapper/" ]; then
#  mkdir -p "$srcPath/mapper/"
#fi
#
# rm -fr  $srcPath
#rm -fr  "$targetPath"
echo " ------ clear all finished ------ "

echo " ------ generate start---- pls wait...------ "
cmd="mybatis-generator:generate -Dmybatis.generator.configurationFile=src/main/resources/generatorConfig.xml"

#/usr/local/bin/mvn $cmd
mvn $cmd

echo "========================finish=========================="

if [ ! -d "$targetPath/entity/" ]; then
  mkdir -p "$targetPath/entity/"
fi

if [ ! -d "$targetPath/mapper/" ]; then
  mkdir -p "$targetPath/mapper/"
fi

echo " ------ move the entity generate code to source code path...------ "
cp -R "./$srcPath/entity/"  "$targetPath/entity/"
echo " ------ Finish the entity generate code to source code path...------ "

echo " ------ move the mapper generate code to source code path...------ "
cp -R "./$srcPath/mapper/"  "$targetPath/mapper/"
echo " ------ Finish the mapper generate code to source code path...------ "

cd target/generated-sources
rm -rf mybatis-generator

read