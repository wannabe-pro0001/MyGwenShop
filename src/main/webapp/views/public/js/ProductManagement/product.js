// MAIN //
getcontrol();
function getcontrol()
{
    getElement();
    checkInfoInput();
    if(list_image.length == 1)
        showImage.style.backgroundImage = null;

    btn_Delete.forEach((del)=>{
        del.onclick = ()=>{
            showSuccessToast('xóa');
        }
    })

    for(let img = 0; img < image_item.length - 1; img ++){
        image_item[img].onclick = ()=>{
            showImage.style.backgroundImage = image_item[img].style.backgroundImage;
        }
    }

    btn_add.onclick=()=>{
        showFormInfoProduct();
        btn_update.style.display = "none";
        btn_insert.style.display = "block";
    };
    btn_Edit.forEach((edit)=>{
        edit.onclick = ()=>{
            showFormInfoProduct();
            btn_insert.style.display = "none";
            btn_update.style.display = "block";
        };
    })
    function showFormInfoProduct(){
        resetInputForm(form_infoProduct);
        let layer = document.createElement("div");
        layer.className = "layer";
        document.querySelector("body").appendChild(layer);

        layer.addEventListener("click", ()=>{
            form_infoProduct.style.display = "none";
            layer.remove();
        })
        form_infoProduct.style.display = "block";
    }
    function resetInputForm(element)
    {
        element.querySelectorAll('input').forEach((input)=>{
            input.value = "";
            input.parentElement.classList.remove("invalid");
        })
        element.querySelectorAll('.form-message').forEach((message)=>{
            message.innerHTML = "";
        })
        for(let img = 0; img < list_image.length - 1; img++){
            list_image[img].remove();
        }
        showImage.style.backgroundImage = null;
    }
    icon_minus.forEach((elm)=>{
        elm.onclick = ()=>{
            let elmPar = elm.parentElement;
            elm.parentElement.remove();
            getElement();
            if(elmPar.lastChild.style.backgroundImage == showImage.style.backgroundImage)
            {
                if(list_image.length == 1)
                    showImage.style.backgroundImage = null;
                else
                    showImage.style.backgroundImage = image_item[image_item.length-2].style.backgroundImage;
            }
            if(elmPar.className == list_image[0].className)
            {
                getcontrol();
                plusImages(-1);
            }
        }
    })
}

let slideImageIndex = 0;

function plusImages(firstImage) {
    showSlideImage(slideImageIndex += firstImage);
}
function currentImage(currImage) {
    showImage.style.backgroundImage = list_image[currImage].style.backgroundImage;
}
function showSlideImage(images)
{
    if(list_image.length >= 5)
    {
        if (images < 0) {slideImageIndex = 0}
        if (images > list_image.length - 5) {slideImageIndex = list_image.length - 5;}
        for(let i = slideImageIndex; i < slideImageIndex + 5; i++)
            list_image[i].style.display = "block";
        for(let i = slideImageIndex + 5; i < list_image.length; i++)
            list_image[i].style.display = "none";
        for(let i = slideImageIndex - 1; i >= 0; i--)
            list_image[i].style.display = "none";
    }
}



addColor.addEventListener("click", ()=>{
    let section = document.createElement("section")
    section.innerHTML=`
    <input type="text" class="item-color" value="" placeholder="Nhập tên màu"></input>
    <i class="fa-solid fa-circle-minus icon-minus"></i>
    <span class="form-message"></span>
  `
    listColor.appendChild(section)
    getcontrol();
})


addSize.addEventListener("click", ()=>{
    let section = document.createElement("section")
    section.innerHTML=`
    <input type="text" class="item-size" value="" placeholder="Nhập size"></input>
    <i class="fa-solid fa-circle-minus icon-minus"></i>  
    <span class="form-message"></span>
  `
    listSize.appendChild(section)
    getcontrol();
})

addNewImage.addEventListener("click", ()=>{
    importImage();
})

function importImage() {
    let fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.setAttribute("multiple", "multiple")
    fileInput.click();
    fileInput.onchange = ()=> {
        if (fileInput.multiple)
        {
            for (let file of fileInput.files) {
                setImage(file);
            }
        }
        else{
            setImage(fileInput.files[0])
        }
    };
}
function setImage(file){
    let wrapper = document.createElement("div");
    let img = document.createElement("div");
    let iconRemove = document.createElement("i");
    iconRemove.className="fa-solid fa-circle-minus icon-minus";
    wrapper.className = "image-item_wrapper";
    img.className = "image-item";
    wrapper.appendChild(iconRemove);
    wrapper.appendChild(img);
    list_image_wrap.insertBefore(wrapper, list_image[list_image.length-1]);
    img.style.backgroundImage = `url(${URL.createObjectURL(file)})`;
    getcontrol();
    showImage.style.backgroundImage = image_item[image_item.length-2].style.backgroundImage;
    plusImages(1);
}
