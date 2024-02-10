export const isEmptyValue = (value) => !value 
export const isLengthValid = (value, min, max) => value.length >= min && value.length <= max
export const isImageTypeValid = (value) => {
    const validExtensions = ['jpg', 'jpeg', 'png', 'gif']
    const extension = value.type.split('/').pop()
    return validExtensions.includes(extension)
}
export const isImageSizeValid = (value) => value.size <= 3 * 1024 * 1024