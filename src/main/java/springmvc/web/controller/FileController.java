package springmvc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    private File folder;

    @Autowired
    private WebApplicationContext context;

    @PostConstruct
    private void init()
    {
        folder = new File(
            context.getServletContext().getRealPath( "/WEB-INF/files" ) );
        if( !folder.exists() ) folder.mkdirs();
    }

    @RequestMapping(value = "/files.html", method = RequestMethod.GET)
    public String files( ModelMap models )
    {
        models.put( "files", folder.listFiles() );
        return "files";
    }

    @RequestMapping(value = "/upload.html", method = RequestMethod.POST)
    public String upload(
        @RequestParam(name = "file") MultipartFile uploadedFile )
        throws IllegalStateException, IOException
    {
        uploadedFile.transferTo(
            new File( folder, uploadedFile.getOriginalFilename() ) );

        return "redirect:files.html";
    }

    @RequestMapping("/download.html")
    public String download( @RequestParam String name,
        HttpServletResponse response ) throws IOException
    {
        File file = new File( folder, name );

        response.setHeader( "Content-Disposition", "inline; filename=" + name );
        response.setHeader( "Content-Length", "" + file.length() );
        FileInputStream in = new FileInputStream( file );
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );
        in.close();

        return null;
    }

}
