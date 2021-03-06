import React, {useCallback} from "react"
import {useDropzone} from 'react-dropzone'

function Dropzone() {
    const onDrop = useCallback(acceptedFiles => {
      // Do something with the files
      const file = acceptedFiles[0];
      console.log(file);
    }, [])
    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})
  
    return (
      <div {...getRootProps()}>
        <input {...getInputProps()} />
        {
          isDragActive ?
            <p>Drop the image here ...</p> :
            <p>Drag 'n' drop image, or click to select image</p>
        }
      </div>
    )
  }

export default Dropzone;