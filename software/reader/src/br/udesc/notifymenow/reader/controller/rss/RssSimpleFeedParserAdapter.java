/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.rss;

import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.util.Logger;
import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.FeedException;
import com.ernieyu.feedparser.FeedParser;
import com.ernieyu.feedparser.FeedParserFactory;
import com.ernieyu.feedparser.Item;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class RssSimpleFeedParserAdapter implements RssReader {

    @Override
    public List<Noticia> retrieve(String url) {
        return retrieve(url, null);
    }

    @Override
    public List<Noticia> retrieve(String url, boolean cache) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noticia> retrieve(String url, Date date) {
        List<Noticia> feeds = new ArrayList<>();

        InputStream feedStream = null;
        FeedParser parser = FeedParserFactory.newParser();
        Feed response;
        try {
            feedStream = getStream(url);
            response = parser.parse(feedStream);
            Iterator list = response.getItemList().iterator();

            while (list.hasNext()) {
                Item requestFeed = (Item) list.next();

                if (date == null || date.before(requestFeed.getPubDate())) {
                    Noticia feed = new Noticia();
                    feed.setConteudo(requestFeed.getDescription());
                    feed.setTitulo(requestFeed.getTitle());
                    feed.setLink(requestFeed.getLink());
                    feed.setData(requestFeed.getPubDate());

                    feeds.add(feed);
                } else {
                    break;
                }
            }
        } catch (FeedException ex) {
            Logger.error(ex);
        } finally {
            try {
                feedStream.close();
            } catch (IOException ex) {
                Logger.error(ex);
            }
        }


        return feeds;
    }

    private InputStream getStream(String url) {
        InputStream feedStream = null;

        try {
            URL address = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) address.openConnection();
            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try {
                    feedStream = httpConnection.getInputStream();
                } catch (IOException ex) {
                    Logger.error(ex);
                }
            }
        } catch (IOException ex) {
            Logger.error(ex);
        }

        return feedStream;
    }

}
