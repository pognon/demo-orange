<div class="row-fluid color-white">
		<div id="nav-gallery" class="font-size-6">
			<a onclick="prev();" id="prev" href="#"><em>prev</em></a>

			<span id="position"> 
				<em class="on">&bull;</em>
				<em>&bull;</em> 
				<em>&bull;</em>
			</span> <a onclick="next();" id="next" href="#"><em>next</em></a>
		</div>
</div>



<div id="slider" class="row-fluid color-white"> 
			<ul>
				<li style='display: block'  >
						<div>
							<img src="<c:url value='/img/dog/dog1.png'/>" />
						</div>
				</li>
				<li style='display: none'  >
					<div>
							<img src="<c:url value='/img/dog/dog2.png'/>" />
						</div>
				</li>
				<li style='display: none'  >
					<div>
							<img src="<c:url value='/img/dog/dog3.png'/>" />
						</div>
				</li>
				<li style='display: none'  ></li>
			</ul>
</div>

<div class="well well-small">
  <div class="btn-group">
  <button class="btn">Z</button>
  <button class="btn">R</button>
  <button class="btn">C</button>
  <button class="btn">B</button>
</div>
  
</div>


<!-- Scripts js pour swiper -->
	<script type="text/javascript" charset="utf-8" src="<c:url value='http://ajax.cdnjs.com/ajax/libs/swipe/1.0/swipe.min.js'/>" /></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/js/bca_swipe.js'/>" /></script>

<script type="text/javascript">

function next(pageId){
	console.log("next called....");
	
	slider.next();
	return false;

}

function prev(pageId){
	console.log("prev called....");
	
	slider.prev();
	return false;

}

</script>

	