category_control();
function category_control()
{
    getElement();
    checkInfoInput();
    btn_Delete.forEach((del)=>{
        del.onclick = ()=>{
            showSuccessToast('xóa');
        }
    })
    btn_Edit.forEach((edit)=>{
        edit.onclick = ()=>{

        };
    })
}