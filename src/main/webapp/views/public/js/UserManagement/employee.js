
function employee_control()
{
    closeFormMember.addEventListener("click", ()=>{
        layer.style.display = "none"
        form_informMember.style.display = "none";
    })


    getInforMember.forEach((item) => {
        item.addEventListener("dblclick", () =>{
            layer.style.display = "block";
            form_informMember.style.display = "flex"
            btn_insert.style.display = "none"
            btn_update.style.display = "block";
            btn_delete.style.display = "block";
            getDataTable = item.querySelectorAll("td")
            for (let value = 0; value < InforMember.length; value++)
            {
                InforMember[value].value = getDataTable[value + 2].innerHTML;
            }
            form_informMember.querySelector("#role").value = item.querySelector("td[name=position]").innerHTML
            Reset_validator();
        })
    })

    btn_add.addEventListener("click", showFromInfor)
    function showFromInfor()
    {
        layer.style.display = "block";
        form_informMember.style.display = "flex"
        btn_insert.style.display = "block";
        btn_update.style.display = "none";
        btn_delete.style.display = "none";
        InforMember.forEach((input)=>input.value = "")
        Reset_validator();
    }

    btn_insert.addEventListener("click", ()=>{

    })
    btn_update.addEventListener("click", ()=>{

    })
    btn_delete.addEventListener("click", ()=>{

    })
}

employee_control();