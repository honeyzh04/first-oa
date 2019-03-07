var addressInit = function(_cmbProvince, _cmbCity, _cmbArea, defaultProvince, defaultCity, defaultArea)
{
	var cmbProvince = document.getElementById(_cmbProvince);
	var cmbCity = document.getElementById(_cmbCity);
	var cmbArea = document.getElementById(_cmbArea);
	
	function cmbSelect(cmb, str)
	{
		for(var i=0; i<cmb.options.length; i++)
		{
			if(cmb.options[i].value == str)
			{
				cmb.selectedIndex = i;
				return;
			}
		}
	}
	function cmbAddOption(cmb, str, obj)
	{
		var option = document.createElement("OPTION");
		cmb.options.add(option);
		option.innerText = str;
		option.value = str;
		option.obj = obj;
	}
	
	function changeCity()
	{
		cmbArea.options.length = 0;
		if(cmbCity.selectedIndex == -1)return;
		var item = cmbCity.options[cmbCity.selectedIndex].obj;
		for(var i=0; i<item.areaList.length; i++)
		{
			cmbAddOption(cmbArea, item.areaList[i], null);
		}
		cmbSelect(cmbArea, defaultArea);
	}
	function changeProvince()
	{
		cmbCity.options.length = 0;
		cmbCity.onchange = null;
		if(cmbProvince.selectedIndex == -1)return;
		var item = cmbProvince.options[cmbProvince.selectedIndex].obj;
		for(var i=0; i<item.cityList.length; i++)
		{
			cmbAddOption(cmbCity, item.cityList[i].name, item.cityList[i]);
		}
		cmbSelect(cmbCity, defaultCity);
		changeCity();
		cmbCity.onchange = changeCity;
	}
	
	for(var i=0; i<provinceList.length; i++)
	{
		cmbAddOption(cmbProvince, provinceList[i].name, provinceList[i]);
	}
	cmbSelect(cmbProvince, defaultProvince);
	changeProvince();
	cmbProvince.onchange = changeProvince;
}
 
var provinceList = [
{name:'四川', cityList:[		   
{name:'成都市', areaList:['锦江区','青羊区','金牛区','武侯区','成华区','龙泉驿区','青白江区','新都区','温江区','金堂县','双流区','郫都区','大邑县','蒲江县','新津县','都江堰市','彭州市','邛崃市','崇州市','简阳市','高新区','天府新区']},		   
{name:'自贡市', areaList:['自流井区','贡井区','大安区','沿滩区','荣　县','富顺县']},		   
{name:'攀枝花市', areaList:['东　区','西　区','仁和区','米易县','盐边县']},		   
{name:'泸州市', areaList:['江阳区','纳溪区','龙马潭区','泸　县','合江县','叙永县','古蔺县']},		   
{name:'德阳市', areaList:['旌阳区','中江县','罗江县','广汉市','什邡市','绵竹市']},		   
{name:'绵阳市', areaList:['涪城区','游仙区','三台县','盐亭县','安　县','梓潼县','北川羌族自治县','平武县','江油市']},		   
{name:'广元市', areaList:['利州区','元坝区','朝天区','旺苍县','青川县','剑阁县','苍溪县']},		   
{name:'遂宁市', areaList:['船山区','安居区','蓬溪县','射洪县','大英县']},		   
{name:'内江市', areaList:['市中区','东兴区','威远县','资中县','隆昌县']},		   
{name:'乐山市', areaList:['市中区','沙湾区','五通桥区','金口河区','犍为县','井研县','夹江县','沐川县','峨边彝族自治县','马边彝族自治县','峨眉山市']},		   
{name:'南充市', areaList:['顺庆区','高坪区','嘉陵区','南部县','营山县','蓬安县','仪陇县','西充县','阆中市']},		   
{name:'眉山市', areaList:['东坡区','仁寿县','彭山县','洪雅县','丹棱县','青神县']},		   
{name:'宜宾市', areaList:['翠屏区','宜宾县','南溪县','江安县','长宁县','高　县','珙　县','筠连县','兴文县','屏山县']},		   
{name:'广安市', areaList:['广安区','岳池县','武胜县','邻水县','华莹市']},		   
{name:'达州市', areaList:['通川区','达　县','宣汉县','开江县','大竹县','渠　县','万源市']},		   
{name:'雅安市', areaList:['雨城区','名山县','荥经县','汉源县','石棉县','天全县','芦山县','宝兴县']},		   
{name:'巴中市', areaList:['巴州区','通江县','南江县','平昌县']},		   
{name:'资阳市', areaList:['雁江区','安岳县','乐至县','简阳市']},		   
{name:'阿坝藏族羌族自治州', areaList:['汶川县','理　县','茂　县','松潘县','九寨沟县','金川县','小金县','黑水县','马尔康县','壤塘县','阿坝县','若尔盖县','红原县']},		   
{name:'甘孜藏族自治州', areaList:['康定县','泸定县','丹巴县','九龙县','雅江县','道孚县','炉霍县','甘孜县','新龙县','德格县','白玉县','石渠县','色达县','理塘县','巴塘县','乡城县','稻城县','得荣县']},		   
{name:'凉山彝族自治州', areaList:['西昌市','木里藏族自治县','盐源县','德昌县','会理县','会东县','宁南县','普格县','布拖县','金阳县','昭觉县','喜德县','冕宁县','越西县','甘洛县','美姑县','雷波县']}
]}
];
